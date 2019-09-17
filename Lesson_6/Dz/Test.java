package Lesson_6.Dz;


public class Test {
}


//// 1
//class A {
//    public static void main(String[] args) {
//        for (byte i = 0; ++i > 0; ) {
//            System.out.println(i);
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//// 2
//class B {
//    int i = getInt();
//    int k = 20;
//    public int getInt() {
//        return k + 1;
//    }
//
//    public static void main(String[] args) {
//        B b = new B();
//        System.out.println(b.i + " " + b.k);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//// 3
//class C {
//    public void process() {
//        System.out.println("C ");
//    }
//}
//
//class D extends C {
//    public void process() throws RuntimeException {
//        super.process();
//        if(true) throw new RuntimeException();
//        System.out.println("D ");
//    }
//
//    public static void main(String[] args) {
//        try {
//            ((C)new D()).process();
//        } catch (Exception e) {
//            System.out.println("Exception print");
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//// 4
//
//class E {
//    public static void main(String[] args) {
//        System.out.println((-(byte)128)>>> 1 == 128 >>> 1);
//        System.out.println(128 >>> 1);
//    }
//}

//
//
//    класс Controller
//
//    public void Dispose() {
//        System.out.println("Отправляем сообщение на сервер о завершении работы");
//        try {
//            if (out != null) {
//                out.writeUTF("/end");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
///////////////////
//
//    Класс  Main
//
//    Controller c;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loader = new FXMLLoader();
//
//        Parent root = loader.load(getClass().getResourceAsStream("sample.fxml"));
//        primaryStage.setTitle("Chat 2k19");
//        c = loader.getController();
//
//        Scene scene = new Scene(root, 310, 350);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        primaryStage.setOnCloseRequest(event -> {
//            c.Dispose();
//            Platform.exit();
//            System.exit(0);
//        });