package com.terralogic.AssignmentTask.Service;

import com.terralogic.AssignmentTask.ExceptionHandler.MultipleIllegalArgumentException;
import com.terralogic.AssignmentTask.Model.Node;
import com.terralogic.AssignmentTask.Repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
public class NodeService {

    private static final Pattern REGEX = Pattern.compile("[!@#$%^&*()]");

    @Autowired
    private NodeRepository nodeRepository;


    //Method to get the list of all Nodes
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }

    //Add a new Node Object to the existing MongoDB collection
    public Node addNode(Node node) {
        List<String> errors = checkNode(node);
        if (!errors.isEmpty()) {
            throw new MultipleIllegalArgumentException(errors);
        }
        return nodeRepository.save(node);
    }

    private List<String> checkNode(Node node) {
        List<String> errors = new ArrayList<>();

        if (node.getNodeId() == null || node.getNodeId().trim().isEmpty()) {
            errors.add("Node ID cannot be null or empty");
        } else if (REGEX.matcher(node.getNodeId()).find()) {
            errors.add("Node ID must not contain special characters");
        }

        if (node.getNodeName() == null || node.getNodeName().trim().isEmpty()) {
            errors.add("Node name cannot be null or empty");
        } else if (REGEX.matcher(node.getNodeName()).find()) {
            errors.add("Node name must not contain special characters");
        }

        if (node.getDescription() == null || node.getDescription().trim().isEmpty()) {
            errors.add("Node Description cannot be null or empty");
        } else if (REGEX.matcher(node.getDescription()).find()) {
            errors.add("Description must not contain special characters");
        }

        if (node.getMemo() == null || node.getMemo().trim().isEmpty()) {
            errors.add("Node Memo cannot be null or empty");
        } else if (REGEX.matcher(node.getMemo()).find()) {
            errors.add("Memo must not contain special characters");
        }

        if (node.getNodeType() == null || node.getNodeType().trim().isEmpty()) {
            errors.add("Node Type cannot be null or empty");
        } else if (REGEX.matcher(node.getNodeType()).find()) {
            errors.add("Node Type must not contain special characters");
        }

        if (node.getParentNodeGroupName() == null || node.getParentNodeGroupName().trim().isEmpty()) {
            errors.add("Parent Node Group Name cannot be null or empty");
        } else if (REGEX.matcher(node.getParentNodeGroupName()).find()) {
            errors.add("Parent Node Group Name must not contain special characters");
        }

        if (node.getParentNodeGroupId() == null || node.getParentNodeGroupId().trim().isEmpty()) {
            errors.add("Parent Node Group ID cannot be null or empty");
        } else if (REGEX.matcher(node.getParentNodeGroupId()).find()) {
            errors.add("Parent Node Group ID must not contain special characters");
        }

        return errors;

    }
}
