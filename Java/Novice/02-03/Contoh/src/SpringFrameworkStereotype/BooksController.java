@Controller
@RequestMapping("books")
public class BooksController
{
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public Employee getBooksByName()
    {
    return booksTemplate;
    }
}
}