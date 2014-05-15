pax-showclix
============

We all know that Showclix has been PAX's ticket vendor for over a year now. This program utilizes Showclix' RESTful API to poll for new events listed under the PAX Prime & Dev seller ID:

http://api.showclix.com/Seller/16886/events

When you launch the program, it will automatically open up your browser to the latest event by the PAX Prim & Dev seller, which, before Prime badges go on sale, will be PAX Dev 2014. It will then continue to poll every 5 seconds, by default (this number can be changed by adding an argument to the `java -jar` call), until an event with a higher ID is found under the PAX Prime & Dev seller.

Naturally, I believe this to be the fastest way to know about tickets being launched, as they have to make the event public before linking to it. That being said, it's not out of the question that they would open up the queue and link to that _before_ making the event public, so **do NOT** stop your other monitoring methods such as Twitter and the website registration link.
