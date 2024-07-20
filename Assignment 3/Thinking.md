# Thinkng Process Yaay | Answers

## 1. Browser Functionality:
1. Structure: Stack    
2. Justification: A stack is the best data structure because of it's LIFO nature. When a user pushes the "Back" button, the last/most recently visited page will remain at the top of the stack allowing you to visit it for easy retrieval immediately after opening a new page.   
3. Description: A stack can be utilised to perform the following operations:
   1. Push operation: anytime a page is visited, that page is placed on top of the stack
   2. Pop: when a user clicks 'back' a URL is popped from the stack and opened for the user to see
   3. Peek: Optionally, the top element can be viewed without having it removed or deleted.

## 2. Text Editor Redo/Undo:
1. Structure: Stack
2. Justification: A stack will allow a user to traverse through undo and redo operations. This is because they can access the first element at the top of their list and downwards which will allow them to undo and traverse back to the top of the list from the bottom which will allow them to redo.
3. Description: We can iutilize stack operations as follows:
   1. We can create two different stacks for undo and redo. 
   2. When a user performs an action we PUSH that action unto the Undo stack.
   3. When the user 'undos' an action, we POP it off the stack, display the opeeration, and then we PUSH it onto the Redo stack. 
   4. If a user undos a repeated number of times but does not redo and performs a new operation, we consider the redo operation lost and await the user to undo this new action and repeat steps 2-3.
   
## 3. Print Queue:
1. Structure: Queue
2. Justification: Printers perform print operations based on a first come, first served basis (FIFO).
3. Description: When printing documents the printer uses a ques system whereby it is able to print the first page as it is the first thing in the queue and the next page being the next thing in the queue.

## 4. Call Center Queue:
1. Structure: Queue
2. Justification: FIFO
3. Description: A call center answers callers calls based on the input at which it comes. THe first caller will be received first and the second caller will be next.

## 4. Mathematical Expression Evaluation:
1. Structure: Stack
2. Justification:
3. Ddescription

## 6. Resource Allocation:
1. Structure: Queue

## 7. Maze Solving:
1. Structure: Stack

8/. Palindrome Checking: Queue



## Problem 1: Identifying the Data Structure (40 points)

### 1. Browser History
1. **Structure**: Stack
2. **Justification**: A stack is the most suitable data structure due to its LIFO nature. When a user clicks the "Back" button, the most recently visited page (last-in) needs to be retrieved first (first-out), making the stack ideal for this operation.
3. **Description**:
   - **Push operation**: Each time a new page is visited, its URL is pushed onto the stack.
   - **Pop operation**: When the "Back" button is clicked, the URL on the top of the stack is popped and the corresponding page is displayed.
   - **Peek operation**: The URL at the top of the stack can be viewed without removing it, allowing for a preview of the last visited page.

### 2. Text Editor Undo/Redo
1. **Structure**: Stack
2. **Justification**: The undo and redo operations in a text editor follow a LIFO pattern. The most recent action needs to be undone first, and if undone actions are to be redone, they should be redone in the reverse order.
3. **Description**:
   - **Undo Stack**: When an action is performed, it is pushed onto the undo stack.
   - **Redo Stack**: When an undo is performed, the action is popped from the undo stack and pushed onto the redo stack.
   - **Redo Operation**: If a redo is required, the action is popped from the redo stack and reapplied.

### 3. Print Queue
1. **Structure**: Queue
2. **Justification**: Printing tasks are handled on a first-come, first-served basis, which follows a FIFO pattern, making a queue the ideal data structure.
3. **Description**:
   - **Enqueue operation**: Each print job is enqueued at the end of the queue.
   - **Dequeue operation**: The printer dequeues the print job at the front of the queue and processes it.

### 4. Call Center Queue
1. **Structure**: Queue
2. **Justification**: Calls are handled in the order they are received, following a FIFO pattern.
3. **Description**:
   - **Enqueue operation**: Each incoming call is enqueued at the end of the queue.
   - **Dequeue operation**: The next available operator dequeues the call at the front of the queue and answers it.

### 5. Mathematical Expression Evaluation
1. **Structure**: Stack
2. **Justification**: Evaluating mathematical expressions, especially in postfix (Reverse Polish Notation) or prefix notation, relies on a LIFO approach where operands are pushed onto the stack and operators pop the necessary operands for evaluation.
3. **Description**:
   - **Push operation**: Operands are pushed onto the stack.
   - **Pop operation**: When an operator is encountered, the required number of operands are popped from the stack, the operation is performed, and the result is pushed back onto the stack.

### 6. Resource Allocation
1. **Structure**: Queue
2. **Justification**: Allocating resources like CPU time or memory often follows a FIFO approach to ensure fair access and avoid starvation.
3. **Description**:
   - **Enqueue operation**: Processes requesting resources are enqueued.
   - **Dequeue operation**: Resources are allocated to the process at the front of the queue.

### 7. Maze Solving
1. **Structure**: Stack
2. **Justification**: Maze solving using depth-first search (DFS) involves exploring a path and backtracking when a dead end is encountered, which aligns with the LIFO nature of a stack.
3. **Description**:
   - **Push operation**: Paths or positions are pushed onto the stack as they are explored.
   - **Pop operation**: When a dead end is reached, positions are popped off the stack to backtrack.

### 8. Palindrome Checking
1. **Structure**: Deque (Double-ended Queue)
2. **Justification**: A deque allows for efficient comparison from both ends of the string, which is necessary for checking palindromes.
3. **Description**:
   - **Add to both ends**: Characters of the string are added to both ends of the deque.
   - **Remove from both ends**: Characters are removed and compared from both ends of the deque to check for equality.
