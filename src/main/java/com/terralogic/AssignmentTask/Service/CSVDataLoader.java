package com.terralogic.AssignmentTask.Service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.terralogic.AssignmentTask.Model.Node;
import com.terralogic.AssignmentTask.Repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class CSVDataLoader implements ApplicationRunner {

    @Autowired
    private NodeRepository nodeRepository;

    @Value("${csv.file.path}")
    private String csvFilePath;

    //This class is to load the CSV data into the MongoDB database , by making use of Application Runner , the data from CSV is loaded into the MongoDB once the Context is initialized
    @Override
    public void run(ApplicationArguments args) {
        try {

            FileReader reader = new FileReader(csvFilePath);

            //Parse CSV file into a list of Node objects
            List<Node> nodes = new CsvToBeanBuilder<Node>(reader)
                    .withType(Node.class)
                    .build()
                    .parse();

            for (Node node : nodes) {
                System.out.println(node);
            }

            //Save nodes to MongoDB
            nodeRepository.saveAll(nodes);

            System.out.println("Nodes loaded into MongoDB successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load nodes from CSV: " + e.getMessage());
        }
    }
}
