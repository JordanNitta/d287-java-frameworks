D287 – JAVA FRAMEWORKS
Name: Jordan Nitta-Rodrigues

Task C
Prompt: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts. Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.
File Name: Edited file mainscreen.html

Line 14: Change the title to Skateboard Professionals
Line 20: Change the title to Skateboard Professionals and changed the CSS to increase the font-size to XXX-Large and made the text centered
Line 19: Change the parts to Skateboard parts
Line 56: Change the products to Skateboard Products

Task D
Prompt: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
File Name: Created About Page called about.html

Added a file called about.html inside the templates folder
Line 9: Added the title for this page
Line 12-14: I created a wrapper to center the title of the page
Line 15-27: Describes Skateboard Profesionals mission and a description about the company
Line 22-24: Created a navigation button that routes users back to home screen
Edited file mainscreen.html

Line 22-26: Created a button that routes to the about page from the home screen
Added custom bootstrap style so the button will be centered in the middle of the screen.

File Name: AboutController located in controller folder
Line 1-13: Created a GetMapping method called aboutPage that routes user to the "/about" page

TASK E
Prompt: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
File Name: BootStrapData

Line 44: Created my logic to make sure that the sample inventory is only added when both the parts and product repositories are empty.
Line 46-50: Create five objects for products.
Line 97-101: After the five product objects are created I save it to the product repository.
Line 52-95: Created two outsource parts objects and three in house parts objects and saved to the part repository.

TASK F
Prompt: Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
    •  The “Buy Now” button must be next to the buttons that update and delete products.
    •  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
    •  Display a message that indicates the success or failure of a purchase.

File Name: Mainscreen.html
Line 95: Created another button using the styles from the buttons above. When clicked the button will send a request to the buyNow route with the specific ProductId of the product clicked.
File Name: notsuccessful.html
Line 5-6: Added bootstrap
Line 7: Created the title of the page
Line 10: Created a container that is center in the middle of the screen.
Line 11: Indicated a message to the user if the purchase was not successful.
Line 13-17: Created a button in the middle of the screen that will route the user back to the home screen.
File Name: successful.html
Line 5-6: Added bootstrap
Line 7: Created the title of the page.
Line 10: Created a container that is center in the middle of the screen.
Line 11: Indicated a message to the user if the purchase was successful.
Line 14-18: Created a button in the middle of the screen that will route the user back to the home screen if they want to continue shopping.
File Name: AddProductController
Line 177: Created a Get request to the buyNow. When this request is made it will run this method.
Line 178: Created a method that takes two parameters. It takes a requestParam that allows a specific productId to be passed into the URL.
Line 180: This allows me to find a product by its ID by using the productService and getting the ID from the database.
Line 182-188: Created logic to check if the product inventory is greater than zero. If the inventory is greater than zero then it decreases the inventory by one and saves it. If it is greater than zero then it will route the user to the successful page. If the inventory is less than zero then it will route the user to the notsuccessful page.

Task G
Modify the parts to track maximum and minimum inventory by doing the following:
    •  Add additional fields to the part entity for maximum and minimum inventory.
    •  Modify the sample inventory to include the maximum and minimum fields.
    •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
    •  Rename the file the persistent storage is saved to.
    •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

File Name: Part.Java located in the domain folder
Line 34-36: Created a column in the database MinInv. Used the @Min annotation field to ensure that the minimum inventory field is greater than zero. If the validation fails it will return the message explaining why.
Line 39-41: Created a column in the database MaxInv. Used the @Min annotation field to ensure that the maximum inventory field is above zero. If the validation fails it will return the message explaining why.
Line 58: Added minInv and maxInv into our constructor as parameters.
Line 63-64: Added minInv and maxInv into the constructor which will allow us to use these fields when we instantiate our object.
Line 67-82: Created getter and setters for bot minInv and maxInv.

File Name: application.properties
Line 6: Changed the datasource name to d287-JordanNittaRodrigues

File Name: InhousePartForm.html
Line 27-28: Created two input fields for minInv and maxInv. I ensured that the th:field uses the same variables used inside the part.java file

File Name: OutsourcedPartForm.html
Line 28-29: Created two input fields for minInv and maxInv. I ensured that the th:field uses the same variables used inside the part.java file

File Name: BootStrapData.java
Line 58-59, 67-68, 75-76, 83-84, 91-92: Added minInv and maxInv to my objects that will be created when the application boots up.

File Name: mainscreen.html
Line 56-57: I added min and max inventory fields, so they will display to users.

File Name: ValidPartMinMaxValidator.java located in validators folder
Line 14: Added a default message to show the inventory must be between minimum and maximum
File Name: PartMinMaxValidator located in validators folder
Line 28-32: Created a method to check if the inventory is less than or equal to min inventory and if parts inventory is less than or equal to max inventory. If it is it will return true which means it will pass the validation. If it does not pass the validation it will hit the else condition where we display our message from the ValidPartMinMaxValidator file.

TASK H
Prompt: Add validation for between or at the maximum and minimum fields. The validation must include the following:
    •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
    •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
    •  Display error messages when adding and updating parts if the inventory is greater than the maximum.

File Name: PartMinMaxValidator.java located in validator folder
Line 34-43: Created two if statement to check if the inventory is less than the minimum inventory. If it is we display a custom error message inventory is below the minimum value. The second if statement checks the inventory is greater than the maximum inventory. If it is we will display a custom message saying inventory is greater than the maximum value.

File Name: inhousePartForm.html
Line 32-37: Displaying all the error messages linked to the form fields. I also added a style so the messages display red.
File Name: OutSourcedPartForm.html
Line 32-37: Displaying all the error messages linked to the form fields. I also added a style so the messages display red.

File Name: EnufPartValidator located in validator folder
Line 38-40: Create logic to ensure that the inventory won't go below the minimum inventory.

TASK I
Prompt: Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
File Name: PartTest
Line 165-181: Added two unit test for testMinInv and testMaxInv. Both of them passed the test.

TASK J
Prompt: Remove the class files for any unused validators in order to clean your code.
File Name: DeletePartValidator
Line: Deleted the DeletePartValidator because it was not used.
