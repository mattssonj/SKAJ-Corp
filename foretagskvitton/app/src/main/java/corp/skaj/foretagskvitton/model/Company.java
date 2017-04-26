package corp.skaj.foretagskvitton.model;

import java.util.ArrayList;
import java.util.List;

import corp.skaj.foretagskvitton.exceptions.IllegalInputException;
import corp.skaj.foretagskvitton.exceptions.NoSuchCardException;
import corp.skaj.foretagskvitton.exceptions.NoSuchEmployeeException;
import corp.skaj.foretagskvitton.exceptions.NoSuchSupplierException;

/**
 *
 */
public class Company {
    private String companyName;
    private List<Employee> listOfEmployees;
    private List<Card> listOfCards;
    private List<Comment> listOfComments;
    private List<Supplier> listOfSuppliers;

    //TODO Check if constructor is needed
    public Company(String companyName, List<Employee> listOfEmployees, List<Card> listOfCards, List<Comment> listOfComments, List<Supplier> listOfSuppliers) {
        this.companyName = companyName;
        this.listOfEmployees = listOfEmployees;
        this.listOfCards = listOfCards;
        this.listOfComments = listOfComments;
        this.listOfSuppliers = listOfSuppliers;
    }

    public Company(String companyName) {
        this.companyName = companyName;
        listOfEmployees = new ArrayList<>();
        listOfCards = new ArrayList<>();
        listOfComments = new ArrayList<>();
        listOfSuppliers = new ArrayList<>();
    }

    /**
     * @param employee
     * @throws IllegalInputException
     */
    public void addEmployee(Employee employee) throws IllegalInputException {
        if (!containsEmployee(employee.getName())) {
            listOfEmployees.add(employee);
        } else {
            throw new IllegalInputException(this);
        }
    }

    /**
     * @param employee
     * @throws NoSuchEmployeeException
     */
    public void removeEmployee(Employee employee) throws NoSuchEmployeeException {
        if (containsEmployee(employee.getName())) {
            listOfEmployees.remove(employee);
        } else {
            throw new NoSuchEmployeeException();
        }
    }

    //TODO Använder vi nedanstående metod? Kommer vi använda den när vi har ovanstående?
    /**
     * @param name
     * @throws NoSuchEmployeeException
     */
    public void removeEmployee(String name) throws NoSuchEmployeeException {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            Employee temp = listOfEmployees.get(i);
            if (temp.getName() == name) {
                listOfEmployees.remove(i);
                return;
            }
        }
        throw new NoSuchEmployeeException();
    }

    /**
     * @param card
     * @throws IllegalInputException
     */
    public void addCard(Card card) throws IllegalInputException {
        if (!containsCard(card.getCard())) {
            listOfCards.add(card);
        } else {
            throw new IllegalInputException(this);
        }
    }

    /**
     * @param card
     * @throws NoSuchCardException
     */
    public void removeCard(Card card) throws NoSuchCardException {
        if (containsCard(card.getCard())) {
            listOfCards.remove(card);
        } else {
            throw new NoSuchCardException();
        }
    }

    /**
     * @param supplier
     * @throws IllegalInputException
     */
    public void addSupplier(Supplier supplier) throws IllegalInputException {
        if (!containsSupplier(supplier.getName())) {
            listOfSuppliers.add(supplier);
        } else {
            throw new IllegalInputException(this);
        }
    }

    /**
     * @param supplier
     * @throws NoSuchSupplierException
     */
    public void removeSupplier(Supplier supplier) throws NoSuchSupplierException {
        for (int i = 0; i < listOfSuppliers.size(); i++) {
            Supplier temp = listOfSuppliers.get(i);
            if (temp.getName() == supplier.getName()) {
                listOfSuppliers.remove(i);
                return;
            }
        }
        throw new NoSuchSupplierException();
    }

    /**
     * @param name
     * @return <code>true</code> if listOfEmployees already contains name
     * <code>false</code> otherwise
     */
    private boolean containsEmployee(String name) {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            Employee temp = listOfEmployees.get(i);
            if (temp.getName() == name) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param cardNumber
     * @return <code>true</code> if listOfCards already contains cardNumber
     * <code>false</code> otherwise
     */
    private boolean containsCard(int cardNumber) {
        for (int i = 0; i < listOfCards.size(); i++) {
            Card temp = listOfCards.get(i);
            if (temp.getCard() == cardNumber) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param name
     * @return <code>true</code> if listOfSuppliers already contains name
     * <code>false</code> otherwise
     */
    private boolean containsSupplier(String name) {
        for (int i = 0; i < listOfSuppliers.size(); i++) {
            Supplier temp = listOfSuppliers.get(i);
            if (temp.toString() == name) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return listOfEmployees
     */
    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    /**
     * @param employeeName
     * @return returns employee with given name, else null
     */
    public Employee getEmployee(String employeeName) {
        for (Employee employee : listOfEmployees) {
            if (employee.getName() == employeeName) {
                return employee;
            }
        }
        return null;
    }

    /**
     * @param purchase
     * @return employee containing given Purchase
     */
    public Employee getEmployee(Purchase purchase) {
        for (Employee employee : listOfEmployees) {
            if (employee.containsPurchase(purchase)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * @param cardNumber
     * @return
     * @throws NoSuchCardException
     */
    public Card getCard(int cardNumber) throws NoSuchCardException {
        for (int i = 0; i < listOfCards.size(); i++) {
            Card temp = listOfCards.get(i);
            if (temp.getCard() == cardNumber) {
                return temp;
            }
        }
        return null;
    }

    /**
     * @return companyName
     */
    public String getName() {
        return companyName;
    }

    /**
     * @return listOfCards
     */
    public List<Card> getCards() {
        return listOfCards;
    }

    /**
     * @return listOfComments
     */
    public List<Comment> getComments() {
        return listOfComments;
    }

    /**
     * @return listOfSuppliers
     */
    public List<Supplier> getSuppliers() {
        return listOfSuppliers;
    }

    /**
     * @return amount of employees in listOfEmployees
     */
    public int getAmountOfEmployees() {
        return listOfEmployees.size();
    }

    /**
     * @return amount of cards in listOfCards
     */
    public int getAmountOfCards() {
        return listOfCards.size();
    }

    /**
     * @return amount of cards in listOfComments
     */
    public int getAmountOfComments() {
        return listOfComments.size();
    }

    /**
     * @return amount of suppliers in listOfSuppliers
     */
    public int getAmountOfSuppliers() {
        return listOfSuppliers.size();
    }
}
