einfachJSON
===========
It is a personal project. I want to make a Java library JSON parser to get JSON notation from objects and to build an object
from a JSON.
For now it only gets JSON notations, Maps and Lists attributes are not supported yet.

To use:
  After importing the jar for your project, you should use the Abstract Class JSONObject, this is for use. To construct an 
  Object for this class there is a Builder named JSONBuilder with the method createJSONObject(). 
    So it is like:
      JSONObject JSONParser = JSONBuilder.createJSONObject();
  Like it only get the JSON notation the only method you can use is objToJSON(Object o) that will return the JSON notation
  for this object o.
  Example:
    public class Test {
      private String first = "test";
      private Integer second = 4;
      
      public static void main(String[] args) throws Exception {
        Test test = new Test();
        JSONObject JSONParser = JSONBuilder.createJSONObject();
        System.out.println(JSONParser.objToJSON(test));
      }
    }
    Should print: {"first": "test", "second": 4}
    
    Or:
    
    public class Other {
      private String third = "other";
      private Double fourth = 3.0;
    }
    
    public class Test {
    
      private String first = "test";
      private Integer second = 4;
      private Other object = new Other();
      
      public static void main(String[] args) throws Exception {
        Test test = new Test();
        JSONObject JSONParser = JSONBuilder.createJSONObject();
        System.out.println(JSONParser.objToJSON(test));
      }
    }
    Should result: {"first": "test", "second": 4, "object": {"third": "other", "fourth": 3.0}}
    
  You can also use the Annotation Ignore from com.lucasmends.einfachjson.annotations for ignoring an attribute, like:
      public class Test {
      @Ignore
      private String first = "test";
      private Integer second = 4;
      
      public static void main(String[] args) throws Exception {
        Test test = new Test();
        JSONObject JSONParser = JSONBuilder.createJSONObject();
        System.out.println(JSONParser.objToJSON(test));
      }
    }
    Should print: {"second": 4}
