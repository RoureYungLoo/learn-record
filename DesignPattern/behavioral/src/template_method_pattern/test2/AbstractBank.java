package template_method_pattern.test2;

public abstract class AbstractBank {
  public abstract void loadUsername();

  public abstract void loadPassword();

  public abstract void verify();

  public abstract void computeBenefits();

  public abstract void showBenefits();

  public void bankTemplate() {
    loadUsername();
    loadPassword();
    verify();
    computeBenefits();
    showBenefits();
  }
}
