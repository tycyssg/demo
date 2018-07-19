package app.config.util;



public class Recursion {

    public String run_recursion(Tier receivedElement) {
        StringBuilder localHtmlHolder = new StringBuilder();

        if (receivedElement.getChildren().size() > 0) {
            localHtmlHolder.append("<li>");
            localHtmlHolder.append("<label label-default='' class='tree-toggle nav-header'>").append(receivedElement.getName()).append("</label>");

            localHtmlHolder.append("<ul class='nav tree'>");
            for (Tier localChildren : receivedElement.getChildren()) {
                localHtmlHolder.append(run_recursion(localChildren));
            }
            localHtmlHolder.append("</ul>");
            localHtmlHolder.append("</li>");
        }else{
            localHtmlHolder.append("<li><a href='#'>").append(receivedElement.getName()).append("</a></li>");
        }

        if (receivedElement.getChildren().size() > 0) {
            localHtmlHolder.append("<li class='divider'></li>");
        }

        return localHtmlHolder.toString();
    }
}

