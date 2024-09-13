## Lab 3: Activity and State Diagrams

### Activity Diagram Problem Statement

A user logs in (or signs up) to Zomato to order food. Before the order is sent to the restaurant, the user must make the payment.
The order is sent to a restaurant, and if the restaurant accepts the order and begins its preparation. If the order is rejected, the user is refunded their money.
When the food is ready, it is picked up by a delivery agent and couriered to the user’s address.
Until the food is delivered, the user cannot make another purchase.

### Activity Diagram

![Activity diagram describing the given problem statement](activity-diagram.drawio.svg)

### State Diagram Problem Statement

The delivery agent logs in to their version of the Zomato app, where they must wait until they get a delivery job.
The agent verifies themself at the restaurant, picks up the order, and delivers it to the address given to them.
While they are enroute, if the customer cancels their order, the agent must return the order to the restaurant.
The agent once again waits for their next job, until they log out.

### State Diagram

![State diagram describing the given problem statement](state-diagram.drawio.svg)
