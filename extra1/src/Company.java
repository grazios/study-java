import java.util.Random;
class Company{
  int assets;

  void paySalary(Employee emp){
    int salary = emp.performance * 2500;

    if(salary > assets){
      System.out.println("資産が足りませんでした…。");
    }else{
      emp.assets += salary;
      assets -= salary;

    }
  }

  void sales(Employee emp){
    int sales = emp.performance * 10000;
    assets += sales;
  }


  public static void main(String[] args){
    Company comp = new Company();
    //3名の社員を雇用
    Employee[] emp = new Employee[3];
    Random ran = new Random();
    //パフォーマンスは1~100のRandom
    for(int i=0; i < emp.length;i++){
      emp[i] = new Employee();
      emp[i].performance += 1 + ran.nextInt(100);
    }

    //売上　給与　のサイクルを１社員につき３回繰り返す

    for(int i=0; i<emp.length;i++){
      for(int j=0;j<3;j++){
        comp.sales(emp[i]);
        comp.paySalary(emp[i]);
      }
    }

    //各社員の資産と会社の資産を出力して終了
    System.out.println("会社の資産は"+comp.assets+"円です。");
    for(int i=0; i<emp.length;i++){
      System.out.println("社員の資産は"+emp[i].assets+"円です。");
    }

  }

}
