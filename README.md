OPC UA Data REST
================

REST Service that can store and serve OPC UA related data using MongoDB.

Related projects
----------------
Frontend project: [OPC UA Data Visualizer](https://github.com/Harha/OPC-UA-Data-Visualizer)

Gateway project: [OPC UA Data Gateway](https://github.com/Harha/OPC-UA-Data-Gateway)

Endpoints
---------
GET (Requires no auth):

- /opcuaservers/{serverId}?endpoint=
- /opcuasubscriptions/{nsIndex}?identifier=&serverId=
- /opcuavariables/{nsIndex}?identifier=&serverId=&serverTimeStampFrom=&serverTimeStampTo=

DELETE, POST, PUT (Requires admin auth):

- /opcuaservers
- /opcuasubscriptions
- /opcuavariables

Accepted data for POST or PUT: application/json

Returned data by GET: application/json

Models
------
OPCUAServer:

- serverId, int, unique
- endpoint, string
- identifier, string

OPCUASubscription:

- identifier, string
- nsIndex, int
- type, string
- serverId, int

OPCUAVariable:

- identifier, string
- nsIndex, int
- type, string
- serverId, int
- value, string
- serverTimeStamp, DateTime (ISO 8601)
- localTimeStamp, DateTime (ISO 8601)

UserAccount:

- username, string, unique
- password, string
- roles, list of string (ADMIN, USER)