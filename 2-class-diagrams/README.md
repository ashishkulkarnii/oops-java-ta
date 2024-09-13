## Lab 2: Class Diagrams

Prepare a detailed class diagram for XYZ Bank, including all classes, their methods and attributes (with visibility notation), relevant relationships (dependencies, generalizations, associations) with cardinalities, enumeration, etc. as described by the case study given below.

### XYZ Bank Case Study

- XYZ Bank is a large banking company, with many branches across various locations. Some details regarding each branch, such as date of inception, IFSC code, address and phone number must be recorded to the system. There must be a method to allow for the opening of new branches.
- A customer is a person (senior citizen or regular), group of people, or firm having an account or deposit with the bank.
- An account can be of three types: savings, checking, or credit. Savings and checking accounts allow withdrawals and deposits, and offer a rate of interest on balance. Credit accounts have a credit limit, must be paid off at the end of each month, and have a penalty rate of interest, calculated monthly.
- A deposit (fixed or recurring) holds the attributes principal amount, rate of interest, tenure, and in case of recurring deposit, the amount that is additionally invested per month. Upon reaching the end of tenure, the amount is sent to a bank account number, which is given during time of opening.
- Each account and deposit is associated with a single branch, but the system allows transferring to a new branch.
- Every branch has employees. The system logs their basic details, an employee ID, and salary. The employees are necessarily account-holders at the same branch.

### Class Diagram

![Class diagram describing the given problem statement](class-diagram.drawio.svg)
