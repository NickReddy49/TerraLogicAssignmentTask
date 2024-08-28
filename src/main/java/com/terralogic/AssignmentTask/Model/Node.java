package com.terralogic.AssignmentTask.Model;

import com.opencsv.bean.CsvBindByName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document(collection = "Nodes")
public class Node {

    @Id
    @NotNull(message = "NodeId cannot be null")
    @CsvBindByName(column = "nodeId")
    private String nodeId;

    @Field("nodeName")
    @NotNull(message = "Node name cannot be null")
    @CsvBindByName(column = "nodeName")
    private String nodeName;

    @Field("description")
    @NotNull(message = "Description cannot be null")
    @CsvBindByName(column = "description")
    private String description;

    @Field("memo")
    @NotNull(message = "Memo cannot be null")
    @CsvBindByName(column = "memo")
    private String memo;

    @Field("nodeType")
    @NotNull(message = "Node type cannot be null")
    @CsvBindByName(column = "nodeType")
    private String nodeType;

    @Field("parentNodeGroupName")
    @NotNull(message = "Parent Node Group Name cannot be null")
    @CsvBindByName(column = "parentNodeGroupName")
    private String parentNodeGroupName;

    @Field("parentNodeGroupId")
    @NotNull(message = "Parent Node Group Id cannot be null")
    @CsvBindByName(column = "parentNodeGroupId")
    private String parentNodeGroupId;

    public Node() {}

    public Node(String nodeId, String nodeName, String description, String memo, String nodeType, String parentNodeGroupName, String parentNodeGroupId) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.description = description;
        this.memo = memo;
        this.nodeType = nodeType;
        this.parentNodeGroupName = parentNodeGroupName;
        this.parentNodeGroupId = parentNodeGroupId;
    }

    // Getters and setters
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getParentNodeGroupName() {
        return parentNodeGroupName;
    }

    public void setParentNodeGroupName(String parentNodeGroupName) {
        this.parentNodeGroupName = parentNodeGroupName;
    }

    public String getParentNodeGroupId() {
        return parentNodeGroupId;
    }

    public void setParentNodeGroupId(String parentNodeGroupId) {
        this.parentNodeGroupId = parentNodeGroupId;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId='" + nodeId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", description='" + description + '\'' +
                ", memo='" + memo + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", parentNodeGroupName='" + parentNodeGroupName + '\'' +
                ", parentNodeGroupId='" + parentNodeGroupId + '\'' +
                '}';
    }
}
