package com.fastcampus.biz.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = -516168697L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategory category = new QCategory("category");

    public final QBlog blog;

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final StringPath categoryName = createString("categoryName");

    public final StringPath description = createString("description");

    public final StringPath displayType = createString("displayType");

    public final ListPath<Post, QPost> postList = this.<Post, QPost>createList("postList", Post.class, QPost.class, PathInits.DIRECT2);

    public QCategory(String variable) {
        this(Category.class, forVariable(variable), INITS);
    }

    public QCategory(Path<? extends Category> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategory(PathMetadata metadata, PathInits inits) {
        this(Category.class, metadata, inits);
    }

    public QCategory(Class<? extends Category> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blog = inits.isInitialized("blog") ? new QBlog(forProperty("blog"), inits.get("blog")) : null;
    }

}

