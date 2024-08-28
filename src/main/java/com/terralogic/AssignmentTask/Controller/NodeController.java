package com.terralogic.AssignmentTask.Controller;

import com.terralogic.AssignmentTask.Model.Node;
import com.terralogic.AssignmentTask.Service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Assignment")
@Validated
public class NodeController {

    @Autowired
    private NodeService nodeService;

    //Post Request is handled using the /AddNode url
    @PostMapping("/AddNode")
    public ResponseEntity<?> addNode(@Valid @RequestBody Node node) {
        Node createdNode = nodeService.addNode(node);
        return new ResponseEntity<>(createdNode, HttpStatus.CREATED);
    }

    //As per Requirement the nodes
    @GetMapping("/getAllNodes")
    public ResponseEntity<List<Node>> getAllNodes() {
        List<Node> nodes = nodeService.getAllNodes();
        return ResponseEntity.ok(nodes);
    }

}
