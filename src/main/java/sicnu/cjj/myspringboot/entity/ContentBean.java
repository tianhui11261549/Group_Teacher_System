package sicnu.cjj.myspringboot.entity;

public class ContentBean {

    private String ques_desc;//评价内容
    private String answer;//每项分数

    public String getQues_desc() {
        return ques_desc;
    }

    public void setQues_desc(String ques_desc) {
        this.ques_desc = ques_desc;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
