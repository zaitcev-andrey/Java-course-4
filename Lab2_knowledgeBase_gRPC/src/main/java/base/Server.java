package base;


import grpc.base.*;
import io.grpc.ServerBuilder;

import java.io.IOException;

import java.util.*;

public class Server extends BaseGrpc.BaseImplBase { // Это наш сервис(в котором будет создан сервер)

    // Нужно переопределить методы

    public void getTags(grpc.base.TagsRequest request,
                        io.grpc.stub.StreamObserver<grpc.base.TagsResponse> responseObserver) {
        String reply = "";
        for(int i = 0; i < tags_list.size(); i++)
            reply += Integer.toString(i) + ") " + tags_list.get(i) + "\n";

        TagsResponse response = TagsResponse.newBuilder().setTags(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted(); // нужно завершить ответы, иначе мы тут зависнем
    }

    public void addTag(grpc.base.TagsRequest request,
                       io.grpc.stub.StreamObserver<grpc.base.TagsResponse> responseObserver) {
        String tag = request.getTags();
        tags_list.add(tag);
        int tag_id = tags_list.size() - 1;
        record_tags_map.put(tag_id, new ArrayList());

        String reply = "";
        for(int i = 0; i < tags_list.size(); i++)
            reply += Integer.toString(i) + ") " + tags_list.get(i) + "\n";
        TagsResponse response = TagsResponse.newBuilder().setTags(reply).setIdNewTag(tag_id).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void delTag(grpc.base.TagsRequest request,
                       io.grpc.stub.StreamObserver<grpc.base.TagsResponse> responseObserver) {
        int del_id = request.getDelTag();
        tags_list.remove(del_id);
        record_tags_map.remove(del_id);

        String reply = "";
        for(int i = 0; i < tags_list.size(); i++)
            reply += Integer.toString(i) + ") " + tags_list.get(i) + "\n";
        TagsResponse response = TagsResponse.newBuilder().setTags(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void getRecords(grpc.base.RecordsRequest request,
                           io.grpc.stub.StreamObserver<grpc.base.RecordsResponse> responseObserver) {
        String reply = "";
        for(int i = 0; i < records_list.size(); i++)
            reply += Integer.toString(i) + ") " + records_list.get(i) + "\n";
        //System.out.println(reply);

        RecordsResponse response = RecordsResponse.newBuilder().setRecords(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void addRecord(grpc.base.RecordsRequest request,
                          io.grpc.stub.StreamObserver<grpc.base.RecordsResponse> responseObserver) {
        String record = request.getRecords();
        records_list.add(record);
        int record_id = records_list.size() - 1;

        String reply = "";
        for(int i = 0; i < records_list.size(); i++)
            reply += Integer.toString(i) + ") " + records_list.get(i) + "\n";
        RecordsResponse response = RecordsResponse.newBuilder().setRecords(reply).setIdRecord(record_id).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void addTagsToRecord(grpc.base.TagsAndRecordsRequest request,
                                io.grpc.stub.StreamObserver<grpc.base.TagsAndRecordsResponse> responseObserver) {
        String record = request.getRecords();
        String tags = request.getTags();

        int id_record = Integer.parseInt(record);

        String str = record + ": ";
        String tmp = "";
        for(int i = 0; i < tags.length(); i++) {
            if(tags.charAt(i) != ' ') {
                tmp += tags.charAt(i);
                continue;
            }
            else {
                if(!tmp.isEmpty()) {
                    int ind = Integer.parseInt(tmp);
                    int flag = 0;
                    ArrayList<Integer> records_with_ind_tag = (ArrayList<Integer>) record_tags_map.get(ind);
                    for(int j = 0; j < records_with_ind_tag.size(); j++) {
                        if(id_record == records_with_ind_tag.get(j)) {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0) {
                        records_with_ind_tag.add(id_record);
                        record_tags_map.put(ind, records_with_ind_tag);
                    }

                    str += tags_list.get(ind) + ", ";
                    tmp = "";
                }
            }
        }
        if(!tmp.isEmpty()) { // обрабатываем последний шаг
            int ind = Integer.parseInt(tmp);
            int flag = 0;
            ArrayList<Integer> records_with_ind_tag = (ArrayList<Integer>) record_tags_map.get(ind);
            for(int j = 0; j < records_with_ind_tag.size(); j++) {
                if(id_record == records_with_ind_tag.get(j)) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                records_with_ind_tag.add(id_record);
                record_tags_map.put(ind, records_with_ind_tag);
            }

            str += tags_list.get(ind);
            tmp = "";
        }

        records_with_tags_list.add(str);

        String reply = "";
        for(int i = 0; i < records_with_tags_list.size(); i++)
            reply += Integer.toString(i) + ") " + records_with_tags_list.get(i) + "\n";
        TagsAndRecordsResponse response = TagsAndRecordsResponse.newBuilder().setRecordsWithTags(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void findRecords(grpc.base.FindRecordsRequest request,
                            io.grpc.stub.StreamObserver<grpc.base.FindRecordsResponse> responseObserver) {

        int id_tag = request.getIdTag();

        String reply = "";
        Iterator iterator = record_tags_map.keySet().iterator();
        while(iterator.hasNext()){
            int key_tag = (int) iterator.next();
            if(id_tag == key_tag) {
                ArrayList<Integer> value_records_list = (ArrayList<Integer>) record_tags_map.get(key_tag);
                for (int i = 0; i < value_records_list.size(); i++) {
                    reply += Integer.toString(value_records_list.get(i)) + ") " + records_list.get(value_records_list.get(i)) + "\n";
                }
            }
        }
        if(reply == "")
            reply = "There are no records for such a tag";

        FindRecordsResponse response = FindRecordsResponse.newBuilder().setRecords(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void addFile(grpc.base.FileRequest request,
                        io.grpc.stub.StreamObserver<grpc.base.FileResponse> responseObserver) {
        int id_record = request.getIdRecord();
        String file_name = request.getNameFile();
        int bytes = request.getNumBytes();

        file_name += ".txt";

        if(!records_files_map.isEmpty()) {
            // добавляем проверку для того, чтобы при вызове get точно знать, что мы вернём объект, а не null
            int flag = 0;
            Iterator iterator = records_files_map.keySet().iterator();
            while(iterator.hasNext()) {
                int key = (int) iterator.next();
                if (key == id_record) {
                    records_files_map.get(id_record).put(file_name, bytes);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                HashMap<String, Integer> file_map = new HashMap();
                file_map.put(file_name, bytes);
                records_files_map.put(id_record, file_map);
            }
        }
        else {
            HashMap<String, Integer> file_map = new HashMap();
            file_map.put(file_name, bytes);
            records_files_map.put(id_record, file_map);
        }

        String reply = "The file '" + file_name + "' with size '" + records_files_map.get(id_record).get(file_name) + "' bytes added to the record: " + id_record;
        FileResponse response = FileResponse.newBuilder().setFile(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void getFile(grpc.base.FileRequest request,
                        io.grpc.stub.StreamObserver<grpc.base.FileResponse> responseObserver) {
        int id_record = request.getIdRecord();
        String file_name = request.getNameFile();

        file_name += ".txt";
        int bytes = 0;

        int flag = 0;
        Iterator iterator = records_files_map.keySet().iterator();
        while(iterator.hasNext()) {
            int key = (int) iterator.next();
            if(key == id_record) {
                HashMap<String, Integer> tmp = records_files_map.get(key);
                Iterator iterator2 = tmp.keySet().iterator();
                while(iterator2.hasNext()) {
                    String key2 = (String) iterator2.next();
                    if(key2.equals(file_name)) {
                        bytes = (int) tmp.get(key2);
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 1)
                break;
        }

        FileResponse response = FileResponse.newBuilder().setNumBytes(bytes).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private static List tags_list = new ArrayList();
    private static List records_list = new ArrayList();
    private static List records_with_tags_list = new ArrayList();
    private static Map record_tags_map = new HashMap(); // ключи - это id метки, а значения - это массивы из id записей
    private static HashMap<Integer, HashMap<String, Integer>> records_files_map = new HashMap<>(); // ключи - это id записи, значения - это файлы(список map из файлов)

    // запускаем этот сервис выше
    public static void main(String[] args) throws IOException, InterruptedException {
        // класс Server в gRPC
        io.grpc.Server server = ServerBuilder
                .forPort(8080)
                .addService(new Server()) // добавили сервис(наш класс)
                .build();

        tags_list.add(0,"People");
        tags_list.add(1,"Movie");
        tags_list.add(2,"Music");
        tags_list.add(3,"Food");
        tags_list.add(4,"Animal");
        tags_list.add(5,"Bird");
        // теперь id созданных меток добавляем в map:
        record_tags_map.put(0, new ArrayList());
        record_tags_map.put(1, new ArrayList());
        record_tags_map.put(2, new ArrayList());
        record_tags_map.put(3, new ArrayList());
        record_tags_map.put(4, new ArrayList());
        record_tags_map.put(5, new ArrayList());

        records_list.add(0,"Cats and dogs like to play");
        records_list.add(1,"I and my friend watched the TV");
        records_list.add(2,"The crow stole the cheese");
        records_list.add(3,"Mozart and Bach are great musicians");

        server.start();
        System.out.println("Server started");

        // чтобы долго работал. Нужно заблокировать поток, в котором работаем, потому что
        // иначе при выходе из main программа прекратит существование
        server.awaitTermination();
    }
}
