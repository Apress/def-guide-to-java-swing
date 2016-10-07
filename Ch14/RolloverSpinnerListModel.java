import javax.swing.*;
import java.util.*;

public class RolloverSpinnerListModel extends SpinnerListModel {

  public RolloverSpinnerListModel(List<?> values) {
    super(values);
  }

  public RolloverSpinnerListModel(Object[] values) {
    super(values);
  }

  public Object getNextValue() {
    Object returnValue = super.getNextValue();
    if (returnValue == null) {
      returnValue = getList().get(0);
    }
    return returnValue;
  }

  public Object getPreviousValue() {
    Object returnValue = super.getPreviousValue();
    if (returnValue == null) {
      List list = getList();
      returnValue = list.get(list.size() - 1);
    }
    return returnValue;
  }
}
