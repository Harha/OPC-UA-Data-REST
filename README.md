OPC UA Data REST
================

REST Service that can store and serve OPC UA related data using MongoDB. Includes authentication via basic auth, user accounts are automatically generated into target MongoDB using the information in app config file for usernames and passwords.

Related projects
----------------
1. Gateway project: [OPC UA Data Gateway](https://github.com/Harha/OPC-UA-Data-Gateway)
2. REST project: [OPC UA Data REST](https://github.com/Harha/OPC-UA-Data-REST)
3. Socket.io project: [OPC UA Data Server](https://github.com/Harha/OPC-UA-Data-Server)
4. Client project: [OPC UA Data Visualizer](https://github.com/Harha/OPC-UA-Data-Visualizer)

Endpoints
---------
1. GET (Requires no auth):
	* /opcuaservers/{serverId}?endpoint=
	* /opcuasubscriptions/{nsIndex}?identifier=&serverId=
	* /opcuavariables/{nsIndex}?identifier=&serverId=&serverTimeStampFrom=&serverTimeStampTo=

2. DELETE, POST, PUT (Requires admin auth):
	* /opcuaservers
	* /opcuasubscriptions
	* /opcuavariables

Accepted data for POST or PUT: application/json

Returned data by GET: application/json

Models
------
1. OPCUAServer:
	* serverId, int, unique
	* endpoint, string
	* identifier, string
2. OPCUASubscription:
	* identifier, string
	* nsIndex, int
	* type, string
	* serverId, int
3. OPCUAVariable:
	* identifier, string
	* nsIndex, int
	* type, string
	* serverId, int
	* value, string
	* serverTimeStamp, DateTime (ISO 8601)
	* localTimeStamp, DateTime (ISO 8601)
4. UserAccount:
	* username, string, unique
	* password, string
	* roles, list of string (ADMIN, USER)