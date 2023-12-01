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
-About.html:
Html document was created and contains information about 
our chosen Customer's company. We included the information
on lines 19-29.
line 30-31 - link back to main page.

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


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet 
each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the 
inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the 
inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


H.  Add validation for between or at the maximum and minimum fields. The validation 
must include the following:
•  Display error messages for low inventory when adding and updating parts if the 
inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers 
the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater 
than the maximum.


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest 
class in the test package.


J.  Remove the class files for any unused validators in order to clean your code.