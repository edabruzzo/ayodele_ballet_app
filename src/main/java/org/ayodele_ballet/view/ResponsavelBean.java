package org.ayodele_ballet.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.ayodele_ballet.model.Responsavel;

/**
 * Backing bean for Responsavel entities.
 * <p/>
 * This class provides CRUD functionality for all Responsavel entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ResponsavelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Responsavel entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Responsavel responsavel;

	public Responsavel getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "ayodele_ballet-persistence-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public String create() {

		this.conversation.begin();
		this.conversation.setTimeout(1800000L);
		return "create?faces-redirect=true";
	}

	public void retrieve() {

		if (FacesContext.getCurrentInstance().isPostback()) {
			return;
		}

		if (this.conversation.isTransient()) {
			this.conversation.begin();
			this.conversation.setTimeout(1800000L);
		}

		if (this.id == null) {
			this.responsavel = this.example;
		} else {
			this.responsavel = findById(getId());
		}
	}

	public Responsavel findById(Long id) {

		return this.entityManager.find(Responsavel.class, id);
	}

	/*
	 * Support updating and deleting Responsavel entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.responsavel);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.responsavel);
				return "view?faces-redirect=true&id="
						+ this.responsavel.getId();
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	public String delete() {
		this.conversation.end();

		try {
			Responsavel deletableEntity = findById(getId());

			this.entityManager.remove(deletableEntity);
			this.entityManager.flush();
			return "search?faces-redirect=true";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	/*
	 * Support searching Responsavel entities with pagination
	 */

	private int page;
	private long count;
	private List<Responsavel> pageItems;

	private Responsavel example = new Responsavel();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Responsavel getExample() {
		return this.example;
	}

	public void setExample(Responsavel example) {
		this.example = example;
	}

	public String search() {
		this.page = 0;
		return null;
	}

	public void paginate() {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		// Populate this.count

		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		Root<Responsavel> root = countCriteria.from(Responsavel.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Responsavel> criteria = builder
				.createQuery(Responsavel.class);
		root = criteria.from(Responsavel.class);
		TypedQuery<Responsavel> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Responsavel> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String nome = this.example.getNome();
		if (nome != null && !"".equals(nome)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nome")),
					'%' + nome.toLowerCase() + '%'));
		}
		String endereco_logradouro = this.example.getEndereco_logradouro();
		if (endereco_logradouro != null && !"".equals(endereco_logradouro)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("endereco_logradouro")),
					'%' + endereco_logradouro.toLowerCase() + '%'));
		}
		String endereco_bairro = this.example.getEndereco_bairro();
		if (endereco_bairro != null && !"".equals(endereco_bairro)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("endereco_bairro")),
					'%' + endereco_bairro.toLowerCase() + '%'));
		}
		String endereco_cidade = this.example.getEndereco_cidade();
		if (endereco_cidade != null && !"".equals(endereco_cidade)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("endereco_cidade")),
					'%' + endereco_cidade.toLowerCase() + '%'));
		}
		String endereco_estado = this.example.getEndereco_estado();
		if (endereco_estado != null && !"".equals(endereco_estado)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("endereco_estado")),
					'%' + endereco_estado.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Responsavel> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Responsavel entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<Responsavel> getAll() {

		CriteriaQuery<Responsavel> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Responsavel.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Responsavel.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ResponsavelBean ejbProxy = this.sessionContext
				.getBusinessObject(ResponsavelBean.class);

		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context,
					UIComponent component, String value) {

				return ejbProxy.findById(Long.valueOf(value));
			}

			@Override
			public String getAsString(FacesContext context,
					UIComponent component, Object value) {

				if (value == null) {
					return "";
				}

				return String.valueOf(((Responsavel) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Responsavel add = new Responsavel();

	public Responsavel getAdd() {
		return this.add;
	}

	public Responsavel getAdded() {
		Responsavel added = this.add;
		this.add = new Responsavel();
		return added;
	}
}
