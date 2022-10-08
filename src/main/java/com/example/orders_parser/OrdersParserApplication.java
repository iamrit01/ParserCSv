package com.example.orders_parser;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class OrdersParserApplication {

	public static void main(String[] args) throws IOException {
		for(String arg: args){
			if(arg.contains(".csv")){
				csvParser(arg);
			}
			else if(arg.contains(".json")){
				jsonParser(arg);
			}
		}

		SpringApplication.run(OrdersParserApplication.class, args);
	}

	public static void csvParser(String fileName){
		String file = fileName;
		new Thread(){
			public void run(){
				try (BufferedReader in = new BufferedReader(new FileReader("/Users/bikry/Desktop/"+file))) {

					List<Orders> orders = in.lines().skip(1).map(line -> {
						String[] x = line.split(" ",4);
						return new Orders(Integer.parseInt(x[0].equals("")?"-1":x[0]), Integer.parseInt(x[1].equals("")?"-1":x[1]), x[2], x[3].replace("\"","").trim());
					}).collect(Collectors.toList());

					int line = 1;
					for(Orders orders1: orders){
						orders1.setLine(line);
						orders1.setFilename(file);
						orders1.setResult("OK");
						System.out.println(orders1);
						line++;
					}


				} catch (StreamWriteException e) {
					e.printStackTrace();
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public static void jsonParser(String fileName){
		String file= fileName;
		new Thread(){
			public void run(){
				try (FileReader reader = new FileReader("/Users/bikry/Desktop/"+file))
				{
					JSONParser parser = new JSONParser();
					Object obj = parser.parse(reader);

					JSONArray orderList = (JSONArray) obj;
					int line = 1;
					for(Object order: orderList) {
						order = (JSONObject) order;
						((JSONObject) order).put("filename", file);
						((JSONObject) order).put("line", line);
						((JSONObject) order).put("result", "OK");
						System.out.println(order);
						line++;
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}.start();

	}

}
