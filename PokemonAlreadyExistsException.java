public class PokemonAlreadyExistsException extends Exception {
    public PokemonAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}