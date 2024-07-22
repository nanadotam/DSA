/**
 * Represents tasks.
 */
class Task {
    String name;

    // Constructor
    Task(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return the name of the object as a string
     */
    @Override
    public String toString() {
        return this.name;
    }
}
