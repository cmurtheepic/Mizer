/**
 * Created by connor on 10/6/2015.
 */
public class RecentSessions {

    private String _SessionEntry;
    private int _EntryId;
    private String _SessionDateCode;
    private String _SessionMathArithmaticType;
    private String _SessionOperation;
    private int _SessionProblemNum1;
    private int _SessionProblemNum2;
    private int _SessionScore;

    public RecentSessions() {

    }

    public RecentSessions(int EntryId, String SessionEntry, String SessionDateCode,
                          String SessionMathArithmaticType, String SessionOperation,
                          int SessionProblemNum1, int SessionProblemNum2, int SessionScore) {
        this._EntryId = EntryId;
        this._SessionEntry = SessionEntry;
        this._SessionDateCode = SessionDateCode;
        this._SessionMathArithmaticType = SessionMathArithmaticType;
        this._SessionOperation = SessionOperation;
        this._SessionProblemNum1 = SessionProblemNum1;
        this._SessionProblemNum2 = SessionProblemNum2;
        this._SessionScore = SessionScore;
    }

    public RecentSessions( int EntryId, String SessionEntry,
                           String SessionMathArithmaticType,
                           String SessionOperation, int SessionProblemNum1,
                           int SessionProblemNum2, int SessionScore) {
        this._EntryId = EntryId;
        this._SessionEntry = SessionEntry;
        this._SessionMathArithmaticType = SessionMathArithmaticType;
        this._SessionOperation = SessionOperation;
        this._SessionProblemNum1 = SessionProblemNum1;
        this._SessionProblemNum2 = SessionProblemNum2;
        this._SessionScore = SessionScore;
    }

    public int get_EntryId() {
        return this._EntryId;
    }

    public void set_EntryId(int EntryId) {
        this._EntryId = EntryId;
    }

    public String get_SessionEntry() {
        return this._SessionEntry;
    }

    public void set_SessionEntry(String SessionEntry) {
        this._SessionEntry = SessionEntry;
    }

    public String get_SessionMathArithmaticType() {
        return this._SessionMathArithmaticType;
    }

    public void set_SessionMathArithmaticType(String SessionMathArithmaticType) {
        this._SessionMathArithmaticType = SessionMathArithmaticType;
    }

    public String get_SessionOperation() {
        return this._SessionOperation;
    }

    public void set_SessionOperation(String SessionOperation) {
        this._SessionOperation = SessionOperation;
    }

    public int get_SessionProblemNum1() {
        return this._SessionProblemNum1;
    }

    public void set_SessionProblemNum1(int SessionProblemNum1) {
        this._SessionProblemNum1 = SessionProblemNum1;
    }

    public int get_SessionProblemNum2() {
        return this._SessionProblemNum2;
    }

    public void set_SessionProblemNum2(int SessionProblemNum2) {
        this._SessionProblemNum2 = SessionProblemNum2;
    }

    public int get_SessionScore() {
        return this._SessionScore;
    }

    public void set_SessionScore(int SessionScore) {
        this._SessionScore = SessionScore;
    }
}
