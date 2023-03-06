public class Main
{
    public static void main(String args[])
    {
        AbbTree a = new AbbTree();
        a.insert("ASAP", "as soon as possible");
        a.insert("AKA" , "also know as");
        a.insert("AI" , "artificial intelligence");
        a.insert("ATM", "at this moment");
        a.insert("B2B", "business to business");
        a.insert("BB", "black berry");

        a.printBranch(3);
    }
}