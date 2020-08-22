from src.main.LinkedList.node import Node


def test_node_object_creation():
    node1 = Node(5)
    assert node1.value == 5
