MERCHANT PRODUCT APP - ECLIPSE IMPORT PROJECT

IMPORTANT
- This is a Maven WAR project for Apache Tomcat 9 (javax.servlet).
- Existing DAO/controller/entity files are retained, with Merchant.products initialized to avoid a null collection for new entities.
- Configure MySQL first: src/main/resources/META-INF/persistence.xml currently uses database merchantproductappdb, user root, password admin. Change these values to match your local MySQL setup. Do not publish real credentials.

IMPORT INTO ECLIPSE
1. Extract this ZIP to a folder.
2. Eclipse: File > Import > Maven > Existing Maven Projects.
3. Browse to the extracted Merchant_Product_App_Eclipse_Ready folder; select pom.xml; Finish.
4. Right-click project > Maven > Update Project.
5. Configure Apache Tomcat 9 in the Servers view.
6. Add Merchant_Product_App to Tomcat and start the server.
7. Open http://localhost:8080/Merchant_Product_App/

If the browser still shows a blank page, check the Eclipse Console and the Tomcat server log. First test the login/register UI, then test DB operations after checking persistence.xml. Bootstrap uses a CDN, so internet is needed for its styling.

Known limitation: Existing DAO classes keep an EntityManager as an instance field. This was intentionally not refactored in this frontend integration package to preserve the backend structure, but it is not safe for concurrent production use. Existing password storage is plain text and should not be used for a public deployment.
