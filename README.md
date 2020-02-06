# bfsEdgesFacebook

Created - November 2019


Work with the Facebook friends network. This is a network of people that are friends with each other. This is an undirected network, since Facebook friend connections are undirected. Each line in the "3980.edges" file is an edge "A B". The opposite edge "B A" also appears somewhere in the file. Therefore, the edges in the "3980.edges" file include a connection from A to B and from B to A to represent undirected edges (friend connections).

All people in the "3980.edges" file have some relation with a Facebook user with id 3980 (obviously the real name has been obscured). The Facebook network originated from SNAP (Links to an external site.).

Implement a Breadth-First Search of the people in this network who are reachable from person id 3980. Print out the distance (number of connections) from person 3980 to every person who is reachable from 3980 via edge traversals. Note that not all people in this network may be reachable via edge traversals from user id 3980, so users that are not accessible can be ignored in BFS.

All the distances printed out are the shortest paths from 3980 and another person as determined by BFS.
