package bit701.day0913;

interface InterJobA
{
  public void insertDb();
  public void deleteDb();
}


// interface끼리의 상속은 extends
interface InterJobB extends InterJobA
{
  public void selectJob();
  public void updateJob();
}

class JobOne implements InterJobA
{


  @Override
  public void insertDb() {
    System.out.println("학생 추가 DB 작업");
  }

  @Override
  public void deleteDb() {
    System.out.println("학생 제거 DB 작업");

  }

}

class JobTwo implements InterJobB
{

  @Override
  public void insertDb() {
    System.out.println("JobTwo의 학생 추가");
  }

  @Override
  public void deleteDb() {
    System.out.println("JobTwo의 학생 제거");

  }

  @Override
  public void selectJob() {
    System.out.println("JobTwo의 학생 조회");

  }

  @Override
  public void updateJob() {
    System.out.println("JobTwo의 학생 수정");

  }

}

public class Ex06_Interface {

  public static void main(String[] args) {

    InterJobA a = new JobOne();
    a.insertDb();
    a.deleteDb();
    System.out.println("-".repeat(10));


    InterJobB b = new JobTwo();
    b.insertDb();
    b.deleteDb();
    b.selectJob();
    b.updateJob();
  }

}
