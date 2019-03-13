

import java.util.List;

public interface ProductDAO  extends DAO {
    List<Product> getProducts() throws DAOException;
    void insert(Product product) throws DAOException;
}
