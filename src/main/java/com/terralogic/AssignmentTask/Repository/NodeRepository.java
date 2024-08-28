
package com.terralogic.AssignmentTask.Repository;

import com.mongodb.lang.Nullable;
import com.terralogic.AssignmentTask.Model.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public interface NodeRepository extends MongoRepository<Node, String> {

    //Declaring the methods to find Nodes by Id and a List to fetch all Nodes , this will be used in Service Classes to fetch the data
    Node findByNodeId(String nodeId);
    @Nullable
    List<Node> findAll();
}
