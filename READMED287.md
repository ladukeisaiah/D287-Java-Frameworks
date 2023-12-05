This is the README for Part B of the WGU D287 Class Task.

TASKS AND CHANGES:

B.  Create a README file that includes notes describing 
where in the code to find the changes you made for each of 
parts C to J. Each note should include the prompt, file name, 
line number, and change.


C.  Customize the HTML user interface for your customer’s application. 
The user interface should include the shop name, the product names, and 
the names of the parts.

CHANGES: 
-mainscreen.html:
line 19 changed to "The Blue Car Shop"
line 21 changed to "Blue Car Parts"
line 53 changed to "Blue Car Products"
line 35 changed to "Car Part"
line 71 changed to "Car Product"

Note: Do not remove any elements that were included in the screen. You may 
add any additional elements you would like or any images, colors, and styles, 
although it is not required.


D.  Add an “About” page to the application to describe your chosen customer’s 
company to web viewers and include navigation to and from the “About” page and 
the main screen.

CHANGES:
-mainscreen.html:
A link was added on line 21 to get to the About Us page

-about.html:
the page was created to display information about the company with 
a simple html setup just like the mainscreen page. Lines 1-15 are all the
initial backbone code to declare our html document and set up the header 
and its associated links. Lines 16-33 contain the body of text/information
and this is where our main content that gets displayed is located.
The main content consists of company info declaring who they are,
where they are located, and a link back to the mainscreen.html
page on lines 30-31. Line 34 is where the closing </html> tag is 
located and completes about.html page.

-AboutController.java
This file was created to handle the HTTP requests and communication
to be able to move between pages on the web application. Without this code we
would be unable to send a request to open the about.html page. the file 
starts out by including a controller package and then importing spring
frameworks and controllers to be able to operate our functions properly
from lines 1-4. Line 5 contains our annotated @controller which marks
it as a Spring MVC controller. within that class we define a method
with @GetMapping to map the URL "about" from lines 6-13. This code
allows us to facilitate the communication of the web application.

E.  Add a sample inventory appropriate for your chosen store to the application. 
You should have five parts and five products in your sample inventory and should 
not overwrite existing data in the database.

Note: Make sure the sample inventory is added only when both the part and product
lists are empty. When adding the sample inventory appropriate for the store, the
inventory is stored in a set so duplicate items cannot be added to your products.
When duplicate items are added, make a “multi-pack” part.

CHANGES:

-BootStrapData.java
In this file i added a starter set of parts and products:
lines 43 & 44 i created two variables to count the length of the
repositories for my if statement.
lines 46-70 i created an if statement that would check if the
repositories are equal to 0 so that they dont continue to add repeats
of the same parts and products to the repositories and make sure there
are no repeats. on lines 47 & 48 i create two arrays one for my
parts and one for the names of the parts that I use in my for loop.
the for loop on lines 50-57 cycles through the length of the array and creates
new objects for the parts. I did it in this way to decrease the length
of code and improve the efficiency of the program.
Lines 59-65 are the creation of the products and adding them to
their correlating repository.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet 
each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the 
inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

CHANGES:

-mainscreen.html
On lines 86-89 I added my button with the input wrapped inside of a <form>
to submit a http Post request, which is used for things like updates to 
inventory and the like. The rest is simple code and also a hidden modifier
to keep the transmitted data hidden from customers.

-buyProduct.java
This file is the @controller file to handle the work/method assigned
in task F. lines 1-17 are my imports. Lines 18-30 are declarations
of variables/classes/objects. lines 32-50 contain our @Controller
code. We declare Post request and carry in the productID identifier
so that our code knows where to subtract a unit of inventory from
or where to check if any are left. the rest of the code is the if statement
to identify if there is any inventory left in the database and then go
to the correct html file depending on if it has one or more or zero.
lines 52-60 display the @GetMapping to take us to the correlating
html file depending on what the if statement produced.

-PurchaseError.html
Lines 1-10 display information that there was an error in the system if the
inventory was below 0 for the product that someone tried to buy as
well as a link back to the main screen.

-purchaseSuccess.html
Lines 1-10 display text saying "purchase successful" if the method
was able to execute properly as well as a link back to the mainscreen.


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the 
inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

CHANGES:
-AddInHousePartController.java
Lines 42-43 were changed to check if the inventory is between the maxInv and minInv.
If it was not within those values it would return an error and would not let the page
change.

-AddOutsourcedPartController.java
Lines 43-44 were added to this file the same as inhouse to check that the inventory
was within the specified min and max range and to throw an error if not.

-application.properties
this file was updated to account for the changed database name.

-BootStrapData.java
Lines 58-59 were for adding the max and min values to my fake inventory
of parts. 

-InhousePartForm.html
lines 26-29 were for adding the inputs for maxInv and minInv so that
users could adjust that number as they pleased.

-OutsourcedPartForm.html
Lines 27-30 were for adding the inputs for maxInv and minInv so that
users could adjust that number as they pleased.

-Part.java
Lines 32-38 were for adding readability with space and for ensuring 
that the integers added to minInv and MaxInv could not be negative numbers.
Lines 47, 51, 52, 55, 60, and 61 were for declaring the minInv, maxInv into 
the class being used. Lines 62-77 were for creating simple get and set 
methods for my max and min inventory features. Lines 108-111 were used
to create the boolean method that would check if inv fell within the range
of the min and max values.

H.  Add validation for between or at the maximum and minimum fields. The validation 
must include the following:
•  Display error messages for low inventory when adding and updating parts if the 
inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers 
the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater 
than the maximum.

CHANGES:

-AddInhousePartController.java
Lines 45-50 were the creation of if statements to produce display errors if 
the inventory the person was trying to add or update exceeded or was less
than the marked minimum and maximum values.

-AddOutsourcedPartController.java
Lines 46-51 were the creation of if statements to produce display errors if
the inventory the person was trying to add or update exceeded or was less
than the marked minimum and maximum values.

-EnufPartsValidator.java
Lines 36-37 I updated the if statement within the isValid method to have another if
statement that would check if the change/update of the product would take
the parts below the minimum number they should have.

-Part.java
Lines 111-117 I added two boolean methods to check if the inventory was
below the marked MinInv or above the maxInv and then use that in the 
if statements for Inhouse and Outsourced part additions and updates.


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest 
class in the test package.

CHANGES:

-partTest.java
lines 159-176 is where the two test units are created for the Maximum and 
minimum part values using @Test.


J.  Remove the class files for any unused validators in order to clean your code.

-DeletePartValidator.java
This file was removed for being an unused class in the validators.