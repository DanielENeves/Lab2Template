import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pt.pa.model.NetworkException;
import pt.pa.model.Person;
import pt.pa.model.UniversityNetwork;

public class UniversityNetworkTest {

    private UniversityNetwork universityNetwork;

    @Before
    public void setUp() {
        universityNetwork = new UniversityNetwork();

        Person student1 = new Person(1, "Student1", Person.PersonRole.STUDENT);
        Person student2 = new Person(2, "Student2", Person.PersonRole.STUDENT);
        Person teacher1 = new Person(3, "Teacher1", Person.PersonRole.TEACHER);

        universityNetwork.addPerson(student1);
        universityNetwork.addPerson(student2);
        universityNetwork.addPerson(teacher1);
    }

    @Test
    public void test_personDoesNotExists_whenEmptyGraph() throws NetworkException {
        UniversityNetwork a = new UniversityNetwork();

        Assert.assertFalse(a.personExists("Rodrigo"));
    }
    @Test
    public void test_Thrown_Exception_afterAddExistentPerson() {
        // Add a person initially
        Person student1 = new Person(135, "Rodrigo", Person.PersonRole.STUDENT);
        universityNetwork.addPerson(student1);

        // Attempt to add the same person again and check if an exception is thrown
        NetworkException thrownException = Assert.assertThrows(NetworkException.class, () -> universityNetwork.addPerson(student1));

        // Verify the exception message or perform additional checks if needed
        Assert.assertEquals("Person with ID 135 already exists in graph!", thrownException.getMessage());
    }

    @Test
    public void test_PersonExist_afterInsert(){
        // Add a person initially
        Person student1 = new Person(135, "Rodrigo", Person.PersonRole.STUDENT);
        universityNetwork.addPerson(student1);

        Assert.assertTrue("Rodrigo", universityNetwork.personExists(student1.getName()));
    }
    /*public void test_isThrown_Exception_afterGetInvalidRelationship() {
        int validId = 1;
        int invalidId = 999;

        assertDoesNotThrow(() -> universityNetwork.addGroupRelationship("Group", validId, validId + 1));

        NetworkException thrownException = assertThrows(NetworkException.class,
                () -> universityNetwork.getRelationships(validId, invalidId));

        assertEquals("Um ou ambos os IDs não são válidos.", thrownException.getMessage());
    }*/
}
