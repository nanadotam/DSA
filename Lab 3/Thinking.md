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
   3. Description:
