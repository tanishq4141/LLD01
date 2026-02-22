public interface PersistenceStorage {
    void save(String name, String content);
    int countLines(String name);
}
