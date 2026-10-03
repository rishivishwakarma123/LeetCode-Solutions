class MyLinkedList {
private:
    struct Node {
        int val;
        Node* prev;
        Node* next;
        Node(int x) : val(x), prev(nullptr), next(nullptr) {}
    };
    
    Node* head;
    Node* tail;
    int size;

public:
    // Initializes the MyLinkedList object.
    MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head->next = tail;
        tail->prev = head;
        size = 0;
    }
    
    // Get the value of the index-th node. Returns -1 if index is invalid.
    int get(int index) {
        if (index < 0 || index >= size) return -1;
        
        Node* curr = nullptr;
        // Optimize traversal by starting from head or tail
        if (index < size / 2) {
            curr = head->next;
            for (int i = 0; i < index; ++i) {
                curr = curr->next;
            }
        } else {
            curr = tail->prev;
            for (int i = 0; i < size - 1 - index; ++i) {
                curr = curr->prev;
            }
        }
        return curr->val;
    }
    
    // Add a node of value val before the first element.
    void addAtHead(int val) {
        Node* pred = head;
        Node* succ = head->next;
        Node* newNode = new Node(val);
        
        newNode->prev = pred;
        newNode->next = succ;
        pred->next = newNode;
        succ->prev = newNode;
        size++;
    }
    
    // Append a node of value val as the last element.
    void addAtTail(int val) {
        Node* succ = tail;
        Node* pred = tail->prev;
        Node* newNode = new Node(val);
        
        newNode->prev = pred;
        newNode->next = succ;
        pred->next = newNode;
        succ->prev = newNode;
        size++;
    }
    
    // Add a node before the index-th node.
    void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        
        Node* pred = nullptr;
        Node* succ = nullptr;
        
        if (index < size / 2) {
            pred = head;
            for (int i = 0; i < index; ++i) {
                pred = pred->next;
            }
            succ = pred->next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) {
                succ = succ->prev;
            }
            pred = succ->prev;
        }
        
        Node* newNode = new Node(val);
        newNode->prev = pred;
        newNode->next = succ;
        pred->next = newNode;
        succ->prev = newNode;
        size++;
    }
    
    // Delete the index-th node if valid.
    void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        Node* curr = nullptr;
        if (index < size / 2) {
            curr = head->next;
            for (int i = 0; i < index; ++i) {
                curr = curr->next;
            }
        } else {
            curr = tail->prev;
            for (int i = 0; i < size - 1 - index; ++i) {
                curr = curr->prev;
            }
        }
        
        Node* pred = curr->prev;
        Node* succ = curr->next;
        pred->next = succ;
        succ->prev = pred;
        
        delete curr;
        size--;
    }
};


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */