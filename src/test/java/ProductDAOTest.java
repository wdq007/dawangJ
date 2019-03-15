
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;


public class ProductDAOTest {
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE products ("
            +"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
            +"name VARCHAR(255) NOT NULL,"
            +"description VARCHAR(1000) DEFAULT NULL,"
            +"price DECIMAL(10,2) NOT NULL,"
            +"PRIMARY KEY (id))";
    private static void createDatabase() {
        String dbUrl = "jdbc:derby:daotest;create=true";
        try (Connection connection = DriverManager.getConnection(dbUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     private static void readDatabase(){
            String READ_TABLE_SQL =
                    "SELECT id,name,description,price FROM products";
            String Url = "jdbc:derby:daotest;create=false";
            try (Connection connection = DriverManager.getConnection(Url);
                 PreparedStatement preparedStatement = connection.prepareStatement(READ_TABLE_SQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            }



    public static void main(String[] args){
        //createDatabase();
        //readDatabase();
        Product product = new Product();
        product.setName("dawang");
        product.setDescription("Wang Daquan");
        product.setPrice(new BigDecimal(33.9));
        ProductDAO productDAO = new ProductDAOImpl();
        try{
            productDAO.insert(product);
        }catch(DAOException e){
            e.printStackTrace();
        }
        List<Product> products = null;
        try{
            products = productDAO.getProducts();
        }catch(DAOException e){
            e.printStackTrace();
        }
        products.stream().forEach(System.out::println);

    }
}
