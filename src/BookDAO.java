import java.sql.*;

public class BookDAO {

    public void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {
        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        (rs.getBoolean("issued") ? "Issued" : "Available")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void issueBook(int id) {
        String sql = "UPDATE books SET issued = TRUE WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Book issued successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int id) {
        String sql = "UPDATE books SET issued = FALSE WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Book returned successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
