@Component
public class Customer
{
    private person person;
}
@Autowired
public Customer(Person person)
{
   this.person=person;
}
}