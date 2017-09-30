package model;

import javax.persistence.*;

@Entity
@Table(name="calls")
@NamedQuery(name = "Call.getAll", query = "SELECT c from Call c")
public class Call extends _IDEntity{

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "abonent_id",
            referencedColumnName = "id")
    private Abonent abonent;

    @Column(name = "calltype")
    @Enumerated(EnumType.STRING)
    private CallType callType;

    @Column
    private String corNumber;

    @Column
    private int duration;

    public Call() {
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public String getCorNumber() {
        return corNumber;
    }

    public void setCorNumber(String corNumber) {
        this.corNumber = corNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Call)) return false;
        if (!super.equals(o)) return false;

        Call call = (Call) o;

        if (duration != call.duration) return false;
        if (abonent != null ? !abonent.equals(call.abonent) : call.abonent != null) return false;
        if (callType != call.callType) return false;
        return corNumber != null ? corNumber.equals(call.corNumber) : call.corNumber == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (abonent != null ? abonent.hashCode() : 0);
        result = 31 * result + (callType != null ? callType.hashCode() : 0);
        result = 31 * result + (corNumber != null ? corNumber.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }

    @Override
    public String toString() {
        return "Call{" +
                "abonent=" + abonent +
                ", callType=" + callType +
                ", corNumber='" + corNumber + '\'' +
                ", duration=" + duration +
                '}';
    }
}
