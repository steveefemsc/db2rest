DB2Rest is an **open-source tool** to rapidly build data access layer with minimal engineering effort. 
DB2Rest connects with your database to instantly provide REST API to perform data access operations(create, read, insert, update) 
and execute stored functions/procedures. 
It takes care of all data access logic and best practices, so that developers can focus on solving complex business logic or building small user-interface components. 
Thus, DB2Rest can provide significant boost to your application delivery and save engineering cost. 

DB2Rest can also act as a secure gateway for legacy databases. This can replace cumbersome, expensive file based data sharing and shared database based integration.
The capability to expose existing data to partners and internal developers securely at scale opens up possibilities of innovation and digital transformation. 

:star: If you find DB2Rest useful, please consider adding a star on GitHub! Your support motivates us to add new exciting features.

![Number of GitHub contributors](https://img.shields.io/github/contributors/kdhrubo/db2rest)
[![Number of GitHub issues that are open](https://img.shields.io/github/issues/kdhrubo/db2rest)](https://github.com/kdhrubo/db2rest/issues)
[![Number of GitHub stars](https://img.shields.io/github/stars/kdhrubo/db2rest)](https://github.com/kdhrubo/db2rest/stargazers)
![Number of GitHub closed issues](https://img.shields.io/github/issues-closed/kdhrubo/db2rest)
![Number of GitHub pull requests that are open](https://img.shields.io/github/issues-pr-raw/kdhrubo/db2rest)
![GitHub release; latest by date](https://img.shields.io/github/v/release/kdhrubo/db2rest)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/kdhrubo/db2rest)
[![GitHub license](https://img.shields.io/github/license/kdhrubo/db2rest)](https://github.com/kdhrubo/db2rest)
![GitHub top language](https://img.shields.io/github/languages/top/kdhrubo/db2rest)
[![Follow us on X, formerly Twitter](https://img.shields.io/twitter/follow/db2rest?style=social)](https://twitter.com/db2rest)


# How does it work?

![DB2Rest- How it works?](assets/db2rest-how-it-works.gif "DB2Rest")




## Benefits

    - No code, no SQL knowledge required, instead use simple REST Query Language (RQL) to retrieve data.
    - Accelerate application development by 30x. 
    - Unlock databases - secure REST API access for legacy data.
    - Blazing fast - No ORM, Single SQL Statement, 1 Database round-trip, does not use code generation.
    - Support for advanced custom queries, bulk data insert, and remote stored procedure calls. 
    - Best practices for transaction management, connection pooling, encryption, security - RBAC / data entitlement.
    - Deploy and run anywhere - on-premise, VM, Kubernetes, or any cloud. 
    - Zero downtime - adjusts to your evolving database schema. 
    - Compatible with DevOps processes. 


# Installation 

## On Premise / On Virtual Machines (VM) 

Refer to [installation quickstart documentation](https://db2rest.com/docs/intro).


## With Docker

Refer to [running with Docker documentation](https://db2rest.com/docs/installation-running-with-docker).



# Supported Databases

- **PostgreSQL**
- **MySQL**

# Supported Features

**Save Record (Create)**

- [x] Single record.
- [x] Bulk records.

**Query (Read)**

- [x] Row Filtering with rSQL DSL.
- [x] Column Selection
- [x] Rename Columns / Alias
- [x] Join - Inner
- [x] Include Join Columns
- [x] Pagination - Limit & Offset
- [X] Sort / Order by
- [ ] Group By
- [ ] Count
- [ ] Join column filter


**Edit**

- [x] Patch
- [x] Patch with row filtering


**Purge (Delete)**

- [x] Delete with row filter.
- [x] Safe delete.

**Transactions**

- [x] Readonly for Select
- [x] Supported for Save, Edit, Purge 

**Multi-tenancy**

- [ ] Tenant Id column
- [x] Schema per tenant
- [ ] Database per tenant

**Schema Support**

- [x] Multiple schema support


# Support

*Connect on Discord*

[![](https://dcbadge.vercel.app/api/server/gytFPNW656?theme=discord)](https://discord.gg/gytFPNW656)



# Contact

<help@db2rest.com>

# Roadmap

Refer to [open roadmap](https://db2rest.com/roadmap/) items.
