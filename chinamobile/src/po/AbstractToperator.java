package po;



/**
 * AbstractToperator generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractToperator  implements java.io.Serializable {


    // Fields    

     private Long operatorId;
     private String operatorName;
     private String operatorPwd;
     private Long isAdmin;


    // Constructors

    /** default constructor */
    public AbstractToperator() {
    }

	/** minimal constructor */
    public AbstractToperator(Long operatorId) {
        this.operatorId = operatorId;
    }
    
    /** full constructor */
    public AbstractToperator(Long operatorId, String operatorName, String operatorPwd, Long isAdmin) {
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorPwd = operatorPwd;
        this.isAdmin = isAdmin;
    }

   
    // Property accessors

    public Long getOperatorId() {
        return this.operatorId;
    }
    
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return this.operatorName;
    }
    
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPwd() {
        return this.operatorPwd;
    }
    
    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public Long getIsAdmin() {
        return this.isAdmin;
    }
    
    public void setIsAdmin(Long isAdmin) {
        this.isAdmin = isAdmin;
    }
   








}