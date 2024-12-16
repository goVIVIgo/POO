package exceções;

public class PlantaNaoExisteException extends Exception {
  public PlantaNaoExisteException(String message) {
    super(message);
  }
}
