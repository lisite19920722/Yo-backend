package tiger.core.domain.account;

import tiger.core.domain.BaseDomain;

/**
 * Created by zhao on 2016/4/18.
 */
public class TestDomain extends BaseDomain {
    private static final long serialVersionUID = 6276854380367631361L;
    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
