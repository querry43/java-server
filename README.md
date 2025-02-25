java-server
===========

This is a sample java app which lacks any sort of persistance backend.  It is a
rough approximation of a java api webapp without the webapp.  The goal is to
configure a backend and connect it up to this service.

This will be paired with administrator access to an AWS account which could
host the data store. If someone would prefer to use Azure or Google Cloud, they
are welcome to bring their own accounts.

Requirements
------------

* github.com account
* computer with internet access
* chrome, firefox, or safari
* access to an email account (for AWS access)

Getting started
---------------

1. Visit https://github.dev/querry43/javas-server
2. Select `Run and Debug` on the left
3. Select `Continue Working On...`
4. Select `Create New Codespace` and pick a small instance type

This app should build and run, but it might take a few more button presses in
the codespace to make that happen.

Tasks
-----

We want to store students (see index.mjs) and any other relevant data in a
persistent and mutable data store.  To this end, we need to:

* Select and create a data store in AWS.
* Configure the data store to hold student data.
* Configure this app to use the data store.

Mock API
--------

`App.getStudents()` - lists all students and their badges

`App.getBadgeSummary()` - lists all badges and the number of times they have been awarded
