import java.io.*;

public class main {
            public static void main(String[] args) {
                // Create a User object
                User user = new User(1, "John Doe", 2500);

                // Serialize the User object
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
                    oos.writeObject(user);
                    System.out.println("User object has been serialized.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Deserialize the User object
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
                    User deserializedUser = (User) ois.readObject();
                    System.out.println("User object has been deserialized:");
                    deserializedUser.displayWorkoutsToConsole();
                    deserializedUser.displayMealsToConsole();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }



