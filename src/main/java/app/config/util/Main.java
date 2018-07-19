package app.config.util;


import java.util.*;


public class Main {
    static List<Tier> menuItems = new ArrayList<>();

    public static void main(String[] args) {
        Map<String,List<String>> moduleUiMap = new LinkedHashMap<String, List<String>>();
        List<String> one = new ArrayList<>();
        one.add("one 1");
        one.add("one 2");
        one.add("one 3");
        one.add("one 4");
        one.add("one 5");
        moduleUiMap.put("one",one);

        List<String> two = new ArrayList<>();
        two.add("two 1");
        two.add("two 2");
        two.add("two 3");
        two.add("two 4");
        two.add("two 5");
        moduleUiMap.put("two",two);

        List<String> twoOneOne = new ArrayList<>();
        twoOneOne.add("two 1 1");
        twoOneOne.add("two 1 2");
        twoOneOne.add("two 1 3");
        twoOneOne.add("two 1 4");
        twoOneOne.add("two 1 5");
        moduleUiMap.put("two 1",twoOneOne);

        transformToListOfObjects(moduleUiMap);

        System.out.printf("Put breakpoint here");
    }

    public static boolean wasEntryAddedToExistingChildren(Tier path, Map.Entry<String, List<String>> entry){
        boolean found = false;
        for(Tier children : path.getChildren()){
            //search inside all the children of the current element
            if(children.hasChildren()){
                //if it has children go in each one of them
                found = wasEntryAddedToExistingChildren(children, entry);
            }

            //when the key we search for is equal to the current children we append it, signal
            // the parent that was found and break out of the search
            if (entry.getKey().equals(children.getName())) {
                children.setChildrenList(entry.getValue());
                found = true;
                break;
            }
        }

        return found;
    }

    public static void transformToListOfObjects(Map<String, List<String>> incomingMap){
        //For every entry found in the DB we must add it to the tree of Tier objects
        for (Map.Entry<String, List<String>> entry : incomingMap.entrySet()){
            boolean found = false;
            Tier buffer = new Tier();

            //For all the possible paths discovered already we
            // inspect if it is possible to add the current entry to one of the children
            for (Tier path: menuItems){
                found = wasEntryAddedToExistingChildren(path,entry);
            }

            //It was not possible to add it, we create a new Tier object with this entry and add it to the list of menu items
            if(!found) {
                buffer.setName(entry.getKey());
                buffer.setChildrenList(entry.getValue());
                menuItems.add(buffer);
            }
        }

    }
}
