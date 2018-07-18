package app.config.util;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public List<Tier> addList(int numberOfElements) {
        List<Tier> children = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            Tier localChildren = new Tier();
            localChildren.setName(String.valueOf(i));
            children.add(localChildren);
        }

        return children;
    }


//   <li>
//       <label label-default="" class="tree-toggle nav-header">Bootstrap</label>
//       <ul class="nav  tree">
//           <li><a href="#">JavaScript</a>
//           </li>
//           <li><a href="#">CSS</a>
//           </li>
//           <li>
//               <label label-default="" class="tree-toggle nav-header">Buttons</label>
//               <ul class="nav  tree">
//                   <li><a href="#">Colors</a> </li>
//                   <li><a href="#">Sizes</a> </li>
//                   <li>
//                       <label label-default="" class="tree-toggle nav-header">Forms</label>
//                       <ul class="nav  tree">
//                           <li><a href="#">Horizontal</a>
//                           </li>
//                           <li><a href="#">Vertical</a>
//                           </li>
//                       </ul>
//                   </li>
//               </ul>
//           </li>
//       </ul>
//   </li>

//   <li class="divider"></li>

//   <li>
//       <label label-default="" class="tree-toggle nav-header">Responsive</label>
//       <ul class="nav  tree">
//           <li><a href="#">Overview</a></li>
//           <li><a href="#">CSS</a></li>
//           <li>
//               <label label-default="" class="tree-toggle nav-header">Media Queries</label>
//               <ul class="nav  tree">
//                   <li><a href="#">Text</a>
//                   </li>
//                   <li><a href="#">Images</a>
//                   </li>
//                   <li>
//                       <label label-default="" class="tree-toggle nav-header">Mobile Devices</label>
//                       <ul class="nav  tree">
//                           <li><a href="#">iPhone</a>
//                           </li>
//                           <li><a href="#">Samsung</a>
//                           </li>
//                       </ul>
//                   </li>
//               </ul>
//           </li>
//           <li>
//               <label label-default="" class="tree-toggle nav-header">Coding</label>
//               <ul class="nav  tree">
//                   <li><a href="#">JavaScript</a>
//                   </li>
//                   <li><a href="#">jQuery</a>
//                   </li>
//                   <li>
//                       <label label-default="" class="tree-toggle nav-header">HTML DOM</label>
//                       <ul class="nav  tree">
//                           <li><a href="#">DOM Elements</a>
//                           </li>
//                           <li><a href="#">Recursive</a>
//                           </li>
//                       </ul>
//                   </li>
//               </ul>
//           </li>
//       </ul>
//   </li>

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

